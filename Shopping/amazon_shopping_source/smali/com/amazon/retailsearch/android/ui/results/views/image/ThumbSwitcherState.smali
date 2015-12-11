.class public Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;
.super Ljava/lang/Object;
.source "ThumbSwitcherState.java"


# instance fields
.field private displayedImage:I

.field private requestedImage:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->displayedImage:I

    .line 10
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->requestedImage:I

    return-void
.end method


# virtual methods
.method public getDisplayedImage()I
    .locals 1

    .prologue
    .line 14
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->displayedImage:I

    return v0
.end method

.method public getRequestedImage()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->requestedImage:I

    return v0
.end method

.method public setDisplayedImage(I)V
    .locals 0
    .param p1, "displayedImage"    # I

    .prologue
    .line 19
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->displayedImage:I

    .line 20
    return-void
.end method

.method public setRequestedImage(I)V
    .locals 0
    .param p1, "requestedImage"    # I

    .prologue
    .line 29
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/image/ThumbSwitcherState;->requestedImage:I

    .line 30
    return-void
.end method
