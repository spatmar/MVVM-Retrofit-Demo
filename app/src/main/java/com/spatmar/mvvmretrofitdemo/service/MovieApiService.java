package com.spatmar.mvvmretrofitdemo.service;

import com.spatmar.mvvmretrofitdemo.model.MovieApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<MovieApiResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("language") String lang);

    @GET("movie/popular")
    Call<MovieApiResponse> getPopularMoviesWithPaging(
            @Query("api_key") String apiKey,
            @Query("language") String lang,
            @Query("page") long page);

}
