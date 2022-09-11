package com.example.ryan.test1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class fragment1 extends Fragment implements View.OnClickListener {

    private View view_fragment;
    private fragment11 fragment11;
    private fragment12 fragment12;
    private fragment13 fragment13;
    private fragment14 fragment14;
    private fragment15 fragment15;
    private fragment16 fragment16;
    private fragment17 fragment17;
    private Fragment mContent;
    private Button[] mTabs;
    private int currentTabIndex;
    private int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        view_fragment = inflater.inflate(R.layout.fragment_1, null);
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
        fragment11 = new fragment11();
        fragment12 = new fragment12();
        fragment13 = new fragment13();
        fragment14 = new fragment14();
        fragment15 = new fragment15();
        fragment16 = new fragment16();
        fragment17 = new fragment17();
        FragmentTransaction beginTransaction = getFragmentManager()
                .beginTransaction();
        beginTransaction
                .add(R.id.data, fragment11);
        beginTransaction.commitAllowingStateLoss();
        mContent = fragment11;
        currentTabIndex = 0;
        mTabs[currentTabIndex].setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                index = 0;
                fragment11 = new fragment11();
                switchContent(fragment11);
                break;
            case R.id.button2:
                index = 1;
                fragment12 = new fragment12();
                switchContent(fragment12);
                break;
            case R.id.button3:
                index = 2;
                fragment13 = new fragment13();
                switchContent(fragment13);
                break;
            case R.id.button4:
                index = 3;
                fragment14 = new fragment14();
                switchContent(fragment14);
                break;
            case R.id.button5:
                index = 4;
                fragment15 = new fragment15();
                switchContent(fragment15);
                break;
            case R.id.button6:
                index = 5;
                fragment16 = new fragment16();
                switchContent(fragment16);
                break;
            case R.id.button7:
                index = 6;
                fragment17 = new fragment17();
                switchContent(fragment17);
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
