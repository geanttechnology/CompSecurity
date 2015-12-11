.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private response:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;

.field private type:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResponse()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->response:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setResponse(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->response:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;

    .line 54
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->type:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->version:Ljava/lang/String;

    .line 48
    return-void
.end method
