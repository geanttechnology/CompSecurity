.class public Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private rate:Ljava/lang/String;

.field private skip:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private update:Ljava/lang/String;

.field private wbody:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getRate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->rate:Ljava/lang/String;

    return-object v0
.end method

.method public getSkip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->skip:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->update:Ljava/lang/String;

    return-object v0
.end method

.method public getWbody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->wbody:Ljava/lang/String;

    return-object v0
.end method

.method public setRate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->rate:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setSkip(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->skip:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->title:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setUpdate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->update:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setWbody(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/ReleaseDialog;->wbody:Ljava/lang/String;

    .line 81
    return-void
.end method
