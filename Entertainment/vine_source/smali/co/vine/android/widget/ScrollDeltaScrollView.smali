.class public Lco/vine/android/widget/ScrollDeltaScrollView;
.super Landroid/widget/ScrollView;
.source "ScrollDeltaScrollView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;
    }
.end annotation


# instance fields
.field private mLastT:I

.field private mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 11
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    .line 12
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mLastT:I

    .line 16
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 11
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    .line 12
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mLastT:I

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 11
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    .line 12
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mLastT:I

    .line 24
    return-void
.end method


# virtual methods
.method protected onScrollChanged(IIII)V
    .locals 2
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 29
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ScrollView;->onScrollChanged(IIII)V

    .line 31
    if-gez p2, :cond_0

    const/4 p2, 0x0

    .line 33
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    if-eqz v0, :cond_1

    .line 34
    iget-object v0, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    iget v1, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mLastT:I

    sub-int/2addr v1, p2

    invoke-interface {v0, v1}, Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;->onScroll(I)V

    .line 36
    :cond_1
    iput p2, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mLastT:I

    .line 37
    return-void
.end method

.method public setScrollDeltaListener(Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    .prologue
    .line 45
    iput-object p1, p0, Lco/vine/android/widget/ScrollDeltaScrollView;->mScrollDeltaListener:Lco/vine/android/widget/ScrollDeltaScrollView$ScrollDeltaListener;

    .line 46
    return-void
.end method
