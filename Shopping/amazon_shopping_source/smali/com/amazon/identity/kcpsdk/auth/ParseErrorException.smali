.class public Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
.super Ljava/lang/Exception;
.source "ParseErrorException.java"


# instance fields
.field final mError:Lcom/amazon/identity/kcpsdk/common/ParseError;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 0
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;->mError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    .line 15
    return-void
.end method


# virtual methods
.method public getError()Lcom/amazon/identity/kcpsdk/common/ParseError;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;->mError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    return-object v0
.end method
