package com.scatl.uestcbbs.module.post.model;

import com.scatl.uestcbbs.annotation.UserPostType;
import com.scatl.uestcbbs.entity.FavoritePostResultBean;
import com.scatl.uestcbbs.entity.ForumListBean;
import com.scatl.uestcbbs.entity.HotPostBean;
import com.scatl.uestcbbs.entity.PostDetailBean;
import com.scatl.uestcbbs.entity.ReportBean;
import com.scatl.uestcbbs.entity.SendPostBean;
import com.scatl.uestcbbs.entity.SingleBoardBean;
import com.scatl.uestcbbs.entity.SubForumListBean;
import com.scatl.uestcbbs.entity.SupportResultBean;
import com.scatl.uestcbbs.entity.UploadResultBean;
import com.scatl.uestcbbs.entity.UserPostBean;
import com.scatl.uestcbbs.entity.VoteResultBean;
import com.scatl.uestcbbs.helper.rxhelper.Observer;
import com.scatl.uestcbbs.util.RetrofitCookieUtil;
import com.scatl.uestcbbs.util.RetrofitUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * author: sca_tl
 * description:
 * date: 2020/1/24 14:32
 */
public class PostModel {
    public void getPostDetail(int page,
                              int pageSize,
                              int order,
                              int topicId,
                              int authorId,
                              String token,
                              String secret,
                              Observer<PostDetailBean> observer) {
        Observable<PostDetailBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .getPostDetailList(page, pageSize, order, topicId, authorId, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void sendPost(String act,
                         String json,
                         String token,
                         String secret,
                         Observer<SendPostBean> observer) {
        Observable<SendPostBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .sendPost(act, json, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void favorite(String idType,
                         String action,
                         int id,
                         String token,
                         String secret,
                         Observer<FavoritePostResultBean> observer) {
        Observable<FavoritePostResultBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .favorite(idType, action, id, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void support(int tid,
                        int pid,
                        String type,
                        String action,
                        String token,
                        String secret,
                        Observer<SupportResultBean> observer) {
        Observable<SupportResultBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .support(tid, pid, type, action, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void userPost(int page,
                         int pageSize,
                         String type,
                         int uid,
                         String token,
                         String secret,
                         Observer<UserPostBean> observer) {
        Observable<UserPostBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .userPost(page, pageSize, uid, type, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void vote(int tid,
                     int boardId,
                     String options,
                     String token,
                     String secret,
                     Observer<VoteResultBean> observer) {
        Observable<VoteResultBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .vote(tid, boardId, options, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getHotPostList(int page,
                               int pageSize,
                               int moduleId,
                               String token,
                               String secret,
                               Observer<HotPostBean> observer) {
        Observable<HotPostBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .getHotPostList(page, pageSize, moduleId, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //上传文件
    public void upload(List<File> files,
                       String module,
                       String type,
                       String token,
                       String secret,
                       Observer<UploadResultBean> observer){

//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);
////                .addFormDataPart("module", module)
////                .addFormDataPart("type", type)
////                .addFormDataPart("accessToken", token)
////                .addFormDataPart("accessSecret", secret);
//
////        List<MultipartBody.Part> partList = new ArrayList<>();
//        if (files != null) {
//
//            for (int i = 0; i < files.size(); i ++) {
////                RequestBody requestBody = RequestBody.create(null, files.get(i));
////                MultipartBody.Part part = MultipartBody.Part.createFormData("uploadFile[]", files.get(i).getName(), requestBody);
////                partList.add(part);
//
//                builder.addFormDataPart("uploadFile[]", files.get(i).getName(),
//                        RequestBody.create(MediaType.parse("image/*"), files.get(i)));
//
//            }
//        }
////
////        RequestBody requestBody = builder.build();
//
////        Map<String, RequestBody> map = new HashMap<>();
////
////        if (files != null) {
////            for (int i = 0; i < files.size(); i ++) {
////                map.put("uploadFile[]; name=" + files.get(i).getName(), RequestBody.create(MediaType.parse("image/*"), files.get(i)));
////            }
////        }
//
////        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), files.get(0));
////        MultipartBody.Part part = MultipartBody.Part.createFormData("uploadFile[]", files.get(0).getName(), requestBody);
//        Observable<UploadResultBean> observable = RetrofitUtil
//                .getInstance()
//                .getApiService()
//                .uploadImage(module, type, token, secret, builder.build());
//        observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
    }

    public void getUserPost(int uid,
                            String token,
                            String secret,
                            Observer<UserPostBean> observer) {
        Observable<UserPostBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .userPost(1, 5, uid, UserPostType.TYPE_USER_POST, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void getForumList(String token,
                             String secret,
                             Observer<ForumListBean> observer) {
        Observable<ForumListBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .forumList(token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getSubForumList(
                            int fid,
                            String token,
                            String secret,
                            Observer<SubForumListBean> observer) {
        Observable<SubForumListBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .subForumList(fid, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getSingleBoardPostList(int page,
                                       int pageSize,
                                       int topOrder,
                                       int boardId,
                                       int filterId,
                                       String filterType,
                                       String sortby,
                                       String token,
                                       String secret,
                                       Observer<SingleBoardBean> observer) {
        Observable<SingleBoardBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .getSingleBoardPostList(page, pageSize, topOrder, boardId, filterId, filterType, sortby, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getRateInfo(int tid, int pid, String token, String secret, Observer<String> observer) {
        Observable<String> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .rateInfo(tid, pid, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void rate(int tid, int pid, int score, String reason, String sendreasonpm,
                     String token, String secret,
                     Observer<String> observer) {
        Observable<String> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .rate(tid, pid, score, reason, sendreasonpm, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void report(String idType, String message, int id,
                     String token, String secret,
                     Observer<ReportBean> observer) {
        Observable<ReportBean> observable = RetrofitUtil
                .getInstance()
                .getApiService()
                .report(idType, message, id, token, secret);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void postAppendFormHash(int tid, int pid,
                       Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .postAppendHash(tid, pid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void postAppendSubmit(int tid, int pid, String formHash, String content,
                                   Observer<String> observer) {

        Map<String, String> map = new HashMap<>();
        map.put("formhash", formHash);
        map.put("handlekey", "");
        map.put("postappendmessage", content);
        map.put("postappendsubmit", "true");

        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .postAppendSubmit(tid, pid, "yes", RetrofitCookieUtil.generateRequestBody(map));
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getDianPingFormHash(int tid, int pid,
                                    Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .getDianPingFormHash(tid, pid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getCommentList(int tid, int pid, int page,
                                 Observer<String> observer) {

        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .getCommentList(tid, pid, page);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getPostWebDetail(int tid, int page, Observer<String> observer) {

        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .getPostWebDetail(tid, page);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getVoteOptions(int tid, Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .getVoteOptions(tid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void viewVoter(int tid, int optionId, int page, Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .viewVoter(tid, optionId, page);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getRateUser(int tid, int pid, Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .getAllRateUser(tid, pid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void sendDianPing(int tid, int pid, String formHash, String content,
                                 Observer<String> observer) {

        Map<String, String> map = new HashMap<>();
        map.put("formhash", formHash);
        map.put("handlekey", "");
        map.put("message", content);
        map.put("commentsubmit", "true");

        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .dianPingSubmit(tid, pid, RetrofitCookieUtil.generateRequestBody(map));
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void findPost(int ptid, int pid, Observer<String> observer) {
        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .findPost(ptid, pid);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void stickReply(String formHash, int fid, int tid,
                           boolean stick, int replyId, Observer<String> observer) {

        Map<String, String> map = new HashMap<>();
        map.put("formhash", formHash);
        map.put("handlekey", "mods");
        map.put("fid", fid + "");
        map.put("tid", tid + "");
        map.put("page", "1");
        map.put("stickreply", stick ? "1" : "0");
        map.put("reason", "");
        map.put("topiclist[]", replyId + "");


        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .stickReply(RetrofitCookieUtil.generateRequestBody(map));
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void uploadAttachment(int uid, int fid, String hash, String fileName, File file, Observer<String> observer) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid + "");
        map.put("hash", hash);
        map.put("filetype", "");
        map.put("Filename", file.getName());

        Map<String, RequestBody> m = RetrofitCookieUtil.generateRequestBody(map);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        m.put("Filedata" + "\"; filename=\"" + fileName, requestBody);

        Observable<String> observable = RetrofitCookieUtil
                .getInstance()
                .getApiService()
                .uploadAttachment(fid, m);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
