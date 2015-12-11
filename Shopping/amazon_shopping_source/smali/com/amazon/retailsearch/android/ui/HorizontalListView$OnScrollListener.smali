.class public interface abstract Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;
.super Ljava/lang/Object;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnScrollListener"
.end annotation


# static fields
.field public static final SCROLL_STATE_FLING:I = 0x2

.field public static final SCROLL_STATE_IDLE:I = 0x0

.field public static final SCROLL_STATE_TOUCH_SCROLL:I = 0x1


# virtual methods
.method public abstract onScroll(Lcom/amazon/retailsearch/android/ui/HorizontalListView;III)V
.end method

.method public abstract onScrollStateChanged(Lcom/amazon/retailsearch/android/ui/HorizontalListView;I)V
.end method
