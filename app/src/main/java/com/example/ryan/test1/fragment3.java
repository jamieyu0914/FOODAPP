package com.example.ryan.test1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment3 extends Fragment implements View.OnClickListener {

    private View view_fragment;
    private fragment31 fragment31;
    private fragment32 fragment32;
    private fragment33 fragment33;
    private fragment34 fragment34;
    private fragment35 fragment35;
    private fragment36 fragment36;
    private fragment37 fragment37;
    private Fragment mContent;
    private Button[] mTabs;
    private int currentTabIndex;
    private int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        view_fragment = inflater.inflate(R.layout.fragment_3, null);
        initfindViewById();
        initFragment();
        return view_fragment;
    }

    private void initfindViewById() {
        mTabs = new Button[7];
        mTabs[0] = (Button) view_fragment
                .findViewById(R.id.button);
        mTabs[1] = (Button) view_fragment
                .findViewById(R.id.button2);
        mTabs[2] = (Button) view_fragment
                .findViewById(R.id.button3);
        mTabs[3] = (Button) view_fragment
                .findViewById(R.id.button4);
        mTabs[4] = (Button) view_fragment
                .findViewById(R.id.button5);
        mTabs[5] = (Button) view_fragment
                .findViewById(R.id.button6);
        mTabs[6] = (Button) view_fragment
                .findViewById(R.id.button7);

        mTabs[0].setOnClickListener(this);
        mTabs[1].setOnClickListener(this);
        mTabs[2].setOnClickListener(this);
        mTabs[3].setOnClickListener(this);
        mTabs[4].setOnClickListener(this);
        mTabs[5].setOnClickListener(this);
        mTabs[6].setOnClickListener(this);
    }

    private void initFragment() {
        fragment31 = new fragment31();
        fragment32 = new fragment32();
        fragment33 = new fragment33();
        fragment34 = new fragment34();
        fragment35 = new fragment35();
        fragment36 = new fragment36();
        fragment37 = new fragment37();
        FragmentTransaction beginTransaction = getFragmentManager()
                .beginTransaction();
        beginTransaction
                .add(R.id.data, fragment31);
        beginTransaction.commitAllowingStateLoss();
        mContent = fragment31;
        currentTabIndex = 0;
        mTabs[currentTabIndex].setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                index = 0;
                fragment31 = new fragment31();
                switchContent(fragment31);
                break;
            case R.id.button2:
                index = 1;
                fragment32 = new fragment32();
                switchContent(fragment32);
                break;
            case R.id.button3:
                index = 2;
                fragment33 = new fragment33();
                switchContent(fragment33);
                break;
            case R.id.button4:
                index = 3;
                fragment34 = new fragment34();
                switchContent(fragment34);
                break;
            case R.id.button5:
                index = 4;
                fragment35 = new fragment35();
                switchContent(fragment35);
                break;
            case R.id.button6:
                index = 5;
                fragment36 = new fragment36();
                switchContent(fragment36);
                break;
            case R.id.button7:
                index = 6;
                fragment37 = new fragment37();
                switchContent(fragment37);
                break;
            default:
                break;
        }
    }

    /** 修改显示的内容 不会重新加载 **/
    public void switchContent(Fragment to) {
        try {
            if (mContent != to) {
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();
                if (!to.isAdded()) { // 先判断是否被add过
                    transaction.hide(mContent)
                            .add(R.id.data, to)
                            .commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                } else {
                    transaction.hide(mContent).show(to)
                            .commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                }
                mContent = to;
            }
            mTabs[currentTabIndex].setSelected(false);
            // 把当前tab设为选中状态
            mTabs[index].setSelected(true);
            currentTabIndex = index;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
