.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private large:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLarge()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;->large:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;

    return-object v0
.end method

.method public setLarge(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/ShortName;->large:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Image;

    .line 29
    return-void
.end method
