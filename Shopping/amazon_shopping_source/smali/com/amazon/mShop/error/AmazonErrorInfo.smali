.class public Lcom/amazon/mShop/error/AmazonErrorInfo;
.super Ljava/lang/Object;
.source "AmazonErrorInfo.java"


# instance fields
.field private mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

.field private mButtonText:Ljava/lang/String;

.field private mErrorId:I

.field private mErrorMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorId:I

    .line 40
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    .line 42
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorMessage:Ljava/lang/String;

    .line 44
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mButtonText:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public constructor <init>(ILcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "errorId"    # I
    .param p2, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "actionButtonText"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorId:I

    .line 40
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    .line 42
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorMessage:Ljava/lang/String;

    .line 44
    iput-object v1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mButtonText:Ljava/lang/String;

    .line 54
    iput p1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorId:I

    .line 55
    iput-object p2, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    .line 56
    iput-object p3, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorMessage:Ljava/lang/String;

    .line 57
    iput-object p4, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mButtonText:Ljava/lang/String;

    .line 58
    return-void
.end method


# virtual methods
.method public getActionButtonText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mButtonText:Ljava/lang/String;

    return-object v0
.end method

.method public getActionListener()Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    return-object v0
.end method

.method public getErrorId()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorId:I

    return v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public setActionButtonText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mButtonText:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setActionListener(Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mActionListener:Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;

    .line 74
    return-void
.end method

.method public setErrorId(I)V
    .locals 0
    .param p1, "errorId"    # I

    .prologue
    .line 65
    iput p1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorId:I

    .line 66
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/error/AmazonErrorInfo;->mErrorMessage:Ljava/lang/String;

    .line 82
    return-void
.end method
