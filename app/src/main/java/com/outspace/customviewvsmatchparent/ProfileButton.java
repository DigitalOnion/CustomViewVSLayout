package com.outspace.customviewvsmatchparent;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 8/15/17.
 */

public class ProfileButton extends ConstraintLayout {

    private String text = null;
    private TextView textView = null;

    public ProfileButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ProfileButton,
                0, 0);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(inflater != null){
            inflater.inflate(R.layout.profile_button, this);
        }

        try {
            text = a.getString(R.styleable.ProfileButton_text);
            for(int i = 0; i < this.getChildCount(); i++) {
                View v = this.getChildAt(i);
                if(v.getId() == R.id.profile_button_txt) textView = (TextView) v;
            }
            if(text != null && textView != null)
                textView.setText(text);

        } finally {
            a.recycle();
        }

    }

}
