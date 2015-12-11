.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;->si:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;->si:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;

    .line 29
    return-void
.end method
