.class public Lcom/amazon/mShop/error/AmazonActivityErrorHandler;
.super Ljava/lang/Object;
.source "AmazonActivityErrorHandler.java"


# instance fields
.field private mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mErrorInfoStack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Lcom/amazon/mShop/error/AmazonErrorInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 1
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    .line 13
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 16
    iput-object p1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 17
    return-void
.end method

.method private setErrorInfoAt(ILcom/amazon/mShop/error/AmazonErrorInfo;)V
    .locals 1
    .param p1, "location"    # I
    .param p2, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0, p1, p2}, Ljava/util/Stack;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 169
    return-void
.end method


# virtual methods
.method public getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/error/AmazonErrorInfo;

    .line 135
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onErrorBoxDisappeared()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    .line 46
    .local v0, "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    if-eqz v0, :cond_0

    .line 47
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/error/AmazonErrorInfo;->setErrorId(I)V

    .line 48
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/error/AmazonErrorInfo;->setActionListener(Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;)V

    .line 49
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/error/AmazonErrorInfo;->setMessage(Ljava/lang/String;)V

    .line 50
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/error/AmazonErrorInfo;->setActionButtonText(Ljava/lang/String;)V

    .line 52
    :cond_0
    return-void
.end method

.method public onErrorReportAt(Lcom/amazon/mShop/error/AmazonErrorInfo;I)V
    .locals 1
    .param p1, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;
    .param p2, "viewIndex"    # I

    .prologue
    .line 32
    if-ltz p2, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-ge p2, v0, :cond_0

    .line 33
    invoke-direct {p0, p2, p1}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->setErrorInfoAt(ILcom/amazon/mShop/error/AmazonErrorInfo;)V

    .line 35
    :cond_0
    return-void
.end method

.method public onPoppedToRoot()V
    .locals 4

    .prologue
    .line 91
    const/4 v0, 0x0

    .line 92
    .local v0, "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    if-eqz v1, :cond_1

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 94
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/Stack;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    check-cast v0, Lcom/amazon/mShop/error/AmazonErrorInfo;

    .line 95
    .restart local v0    # "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 97
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->removeAllElements()V

    .line 98
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v1, v0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v1

    if-eqz v1, :cond_1

    .line 102
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/UIUtils;->createErrorBox(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;)Lcom/amazon/mShop/error/AmazonErrorBox;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/mShop/AmazonActivity;->reportErrorOnView(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/error/AmazonErrorBox;Landroid/view/View;)V

    .line 107
    :cond_1
    return-void
.end method

.method public onPushView()V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 60
    return-void
.end method

.method public onTopViewRemoved()V
    .locals 4

    .prologue
    .line 113
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->dismissErrorBox()V

    .line 114
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    .line 117
    .local v0, "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v1

    if-eqz v1, :cond_0

    .line 119
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v2, v0}, Lcom/amazon/mShop/util/UIUtils;->createErrorBox(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;)Lcom/amazon/mShop/error/AmazonErrorBox;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/mShop/AmazonActivity;->reportErrorOnView(Lcom/amazon/mShop/error/AmazonErrorInfo;Lcom/amazon/mShop/error/AmazonErrorBox;Landroid/view/View;)V

    .line 124
    :cond_0
    return-void
.end method

.method public onViewPopped()V
    .locals 3

    .prologue
    .line 67
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 69
    invoke-virtual {p0}, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->getCurrentErrorInfo()Lcom/amazon/mShop/error/AmazonErrorInfo;

    move-result-object v0

    .line 70
    .local v0, "errorInfo":Lcom/amazon/mShop/error/AmazonErrorInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/mShop/error/AmazonErrorInfo;->getErrorId()I

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v2

    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorInfo;Landroid/view/View;)V

    .line 75
    :cond_0
    return-void
.end method

.method public onViewSwapped()V
    .locals 3

    .prologue
    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->size()I

    move-result v0

    .line 82
    .local v0, "count":I
    const/4 v1, 0x1

    if-ge v1, v0, :cond_0

    .line 83
    iget-object v1, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    add-int/lit8 v2, v0, -0x2

    invoke-virtual {v1, v2}, Ljava/util/Stack;->remove(I)Ljava/lang/Object;

    .line 85
    :cond_0
    return-void
.end method

.method public removeAllErrors()V
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->removeAllElements()V

    .line 176
    return-void
.end method

.method public removeErrorAt(I)V
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 179
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->removeElementAt(I)V

    .line 182
    :cond_0
    return-void
.end method

.method public setCurrentErrorInfo(Lcom/amazon/mShop/error/AmazonErrorInfo;)V
    .locals 1
    .param p1, "errorInfo"    # Lcom/amazon/mShop/error/AmazonErrorInfo;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->empty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonActivityErrorHandler;->mErrorInfoStack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    return-void
.end method
