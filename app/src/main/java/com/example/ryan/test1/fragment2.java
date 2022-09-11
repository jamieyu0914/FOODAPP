package com.example.ryan.test1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class fragment2 extends Fragment implements View.OnClickListener {

    private View view_fragment;
    private fragment21 fragment21;
    private fragment22 fragment22;
    private fragment23 fragment23;
    private fragment24 fragment24;
    private fragment25 fragment25;
    private fragment26 fragment26;
    private fragment27 fragment27;
    private Fragment mContent;
    private Button[] mTabs;
    private int currentTabIndex;
    private int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        view_fragment = inflater.inflate(R.layout.fragment_2, null);
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
        fragment21 = new fragment21();
        fragment22 = new fragment22();
        fragment23 = new fragment23();
        fragment24 = new fragment24();
        fragment25 = new fragment25();
        fragment26 = new fragment26();
        fragment27 = new fragment27();
        FragmentTransaction beginTransaction = getFragmentManager()
                .beginTransaction();
        beginTransaction
                .add(R.id.data, fragment21);
        beginTransaction.commitAllowingStateLoss();
        mContent = fragment21;
        currentTabIndex = 0;
        mTabs[currentTabIndex].setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                index = 0;
                fragment21 = new fragment21();
                switchContent(fragment21);
                break;
            case R.id.button2:
                index = 1;
                fragment22 = new fragment22();
                switchContent(fragment22);
                break;
            case R.id.button3:
                index = 2;
                fragment23 = new fragment23();
                switchContent(fragment23);
                break;
            case R.id.button4:
                index = 3;
                fragment24 = new fragment24();
                switchContent(fragment24);
                break;
            case R.id.button5:
                index = 4;
                fragment25 = new fragment25();
                switchContent(fragment25);
                break;
            case R.id.button6:
                index = 5;
                fragment26 = new fragment26();
                switchContent(fragment26);
                break;
            case R.id.button7:
                index = 6;
                fragment27 = new fragment27();
                switchContent(fragment27);
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
