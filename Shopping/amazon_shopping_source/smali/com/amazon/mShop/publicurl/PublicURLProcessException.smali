.class public Lcom/amazon/mShop/publicurl/PublicURLProcessException;
.super Ljava/lang/Exception;
.source "PublicURLProcessException.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;
    }
.end annotation


# instance fields
.field private mErrorCode:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;)V
    .locals 0
    .param p1, "errorCode"    # Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessException;->mErrorCode:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    .line 18
    return-void
.end method


# virtual methods
.method public errorCode()Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLProcessException;->mErrorCode:Lcom/amazon/mShop/publicurl/PublicURLProcessException$PublicURLErrorCode;

    return-object v0
.end method
