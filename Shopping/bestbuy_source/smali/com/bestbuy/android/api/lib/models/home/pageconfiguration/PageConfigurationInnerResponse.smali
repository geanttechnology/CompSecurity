.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private pageConfiguration:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPageConfiguration()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;->pageConfiguration:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;

    return-object v0
.end method

.method public setPageConfiguration(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;->pageConfiguration:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;

    .line 29
    return-void
.end method
