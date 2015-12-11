.class public Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;
.super Landroid/os/AsyncTask;
.source "SSOUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/SSOUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FetchUserFullNameTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private mListener:Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;

    .prologue
    .line 97
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 98
    iput-object p1, p0, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->mListener:Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;

    .line 99
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 94
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 108
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 111
    .local v0, "accountId":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, ""

    :goto_0
    return-object v1

    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 94
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->mListener:Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;->afterFullnameFetched(Ljava/lang/String;)V

    .line 119
    return-void
.end method

.method protected onPreExecute()V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->mListener:Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;

    invoke-interface {v0}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;->beforeFetchingFullname()V

    .line 104
    return-void
.end method
