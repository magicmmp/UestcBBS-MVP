package com.scatl.uestcbbs.module.message.adapter;

import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scatl.uestcbbs.R;
import com.scatl.uestcbbs.entity.PrivateMsgBean;
import com.scatl.uestcbbs.helper.glidehelper.GlideLoader4Common;
import com.scatl.uestcbbs.util.TimeUtil;

/**
 * author: sca_tl
 * description:
 * date: 2020/1/29 16:25
 */
public class PrivateMsgAdapter extends BaseQuickAdapter<PrivateMsgBean.BodyBean.ListBean, BaseViewHolder> {

    public PrivateMsgAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PrivateMsgBean.BodyBean.ListBean item) {
        helper.setText(R.id.item_private_msg_user_name, item.toUserName)
                .setText(R.id.item_private_msg_content, TextUtils.isEmpty(item.lastSummary) ? "[图片]" : item.lastSummary)
                .setText(R.id.item_private_msg_date,
                        TimeUtil.formatTime(item.lastDateline, R.string.post_time1, mContext))
                .addOnClickListener(R.id.item_private_msg_user_icon);
        GlideLoader4Common.simpleLoad(mContext, item.toUserAvatar, helper.getView(R.id.item_private_msg_user_icon));

        helper.getView(R.id.item_private_msg_unread).setVisibility(item.isNew == 1 ? View.VISIBLE : View.GONE);

    }
}
