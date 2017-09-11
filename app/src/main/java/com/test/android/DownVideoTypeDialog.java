package com.test.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Erica on 2017/8/28.
 */

public class DownVideoTypeDialog extends Dialog implements View.OnClickListener {

    private Activity mContext;
    private TextView flv_1080, flv_720, flv_480;
    private String flv1080, flv720, flv480;
    private String currentSelectedUrl;


    public DownVideoTypeDialog(@NonNull Context context, boolean isFullScreen) {
        super(context, R.style.zone_dialog_dim);
        if (context instanceof Activity) {
            this.mContext = (Activity) context;
        } else {
            Toast.makeText(context, "请传入activity类型的context", Toast.LENGTH_SHORT).show();
        }
        Window dialogWindow = getWindow();

        setContentView(R.layout.dialog_down_video_normal);
        initView();

        setCanceledOnTouchOutside(true);
        /*dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND | WindowManager.LayoutParams.FLAG_DIM_BEHIND);*/
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);// 设置中间
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);
    }

    private void initView() {
        flv_1080 = (TextView) findViewById(R.id.flv_1080);
        flv_720 = (TextView) findViewById(R.id.flv_720);
        flv_480 = (TextView) findViewById(R.id.flv_480);
        flv_1080.setOnClickListener(this);
        flv_720.setOnClickListener(this);
        flv_480.setOnClickListener(this);
        flv480 = "flv480";
        flv720 = "flv720";
        flv1080 = "flv1080";
        setItemVisiable();
    }

    /**
     * 根据视频类型变换不同的UI
     */
    public void setItemVisiable() {
        if (TextUtils.isEmpty(flv1080) && "".equals(flv1080)) {
            flv_1080.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(flv720) && "".equals(flv720)) {
            flv_720.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.flv_1080) {
            currentSelectedUrl = flv1080;
            dismiss();

        }
        if (i == R.id.flv_720) {
            currentSelectedUrl = flv720;
            dismiss();
        }
        if (i == R.id.flv_480) {
            currentSelectedUrl = flv480;
            dismiss();
        }
    }


}
