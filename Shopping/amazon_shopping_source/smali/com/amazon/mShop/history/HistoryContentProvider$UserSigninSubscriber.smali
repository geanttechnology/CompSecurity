.class Lcom/amazon/mShop/history/HistoryContentProvider$UserSigninSubscriber;
.super Ljava/lang/Object;
.source "HistoryContentProvider.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/history/HistoryContentProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UserSigninSubscriber"
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;

.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryContentProvider;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryContentProvider;Landroid/content/Context;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryContentProvider$UserSigninSubscriber;->this$0:Lcom/amazon/mShop/history/HistoryContentProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p2, p0, Lcom/amazon/mShop/history/HistoryContentProvider$UserSigninSubscriber;->mContext:Landroid/content/Context;

    .line 59
    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 8
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 69
    :try_start_0
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 70
    .local v1, "values":Landroid/content/ContentValues;
    const-string/jumbo v2, "email"

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryContentProvider$UserSigninSubscriber;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->PRODUCT_URI:Landroid/net/Uri;

    const-string/jumbo v4, "email=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string/jumbo v7, ""

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 74
    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryContentProvider$UserSigninSubscriber;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/history/HistoryContentProvider;->VISUAL_SEARCH_URI:Landroid/net/Uri;

    const-string/jumbo v4, "email=?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string/jumbo v7, ""

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    .end local v1    # "values":Landroid/content/ContentValues;
    :goto_0
    return-void

    .line 75
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    # getter for: Lcom/amazon/mShop/history/HistoryContentProvider;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/history/HistoryContentProvider;->access$000()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 64
    return-void
.end method
