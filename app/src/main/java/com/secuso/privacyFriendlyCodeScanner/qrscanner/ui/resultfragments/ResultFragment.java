package com.secuso.privacyfriendlycodescanner.qrscanner.ui.resultfragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.zxing.client.result.ParsedResult;
import com.secuso.privacyfriendlycodescanner.qrscanner.ui.viewmodel.ResultViewModel;

public abstract class ResultFragment extends Fragment {

    protected ParsedResult parsedResult;
    protected ResultViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        viewModel = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);
        parsedResult = viewModel.mParsedResult;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(ResultViewModel.class);
        parsedResult = viewModel.mParsedResult;
    }

    public void putQRCode(@NonNull ParsedResult parsedResult) {
        this.parsedResult = parsedResult;
    }

    public abstract void onProceedPressed(Context context);
}
