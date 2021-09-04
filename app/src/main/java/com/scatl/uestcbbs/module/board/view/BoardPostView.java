package com.scatl.uestcbbs.module.board.view;

import com.scatl.uestcbbs.entity.SingleBoardBean;

public interface BoardPostView {
    void onGetBoardPostSuccess(SingleBoardBean singleBoardBean);
    void onGetBoardPostError(String msg);

    void onPaySuccess(String msg);
    void onPayError(String msg);
}
