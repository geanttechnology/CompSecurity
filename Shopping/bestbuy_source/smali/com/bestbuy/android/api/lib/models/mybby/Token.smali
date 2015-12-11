.class public Lcom/bestbuy/android/api/lib/models/mybby/Token;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private accessToken:Ljava/lang/String;

.field private errorCode:Ljava/lang/String;

.field private expriesIn:Ljava/lang/String;

.field private hasError:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->accessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->errorCode:Ljava/lang/String;

    return-object v0
.end method

.method public getExpriesIn()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->expriesIn:Ljava/lang/String;

    return-object v0
.end method

.method public isHasError()Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->hasError:Z

    return v0
.end method

.method public setAccessToken(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->accessToken:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setErrorCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->errorCode:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setExpriesIn(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->expriesIn:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setHasError(Z)V
    .locals 0

    .prologue
    .line 42
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/Token;->hasError:Z

    .line 43
    return-void
.end method
