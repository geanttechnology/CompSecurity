.class public Lcom/bestbuy/android/api/lib/models/registry/ProfileServiceResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/registry/ProfileSIResponse;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/registry/ProfileSIResponse;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/ProfileServiceResponse;->si:Lcom/bestbuy/android/api/lib/models/registry/ProfileSIResponse;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/registry/ProfileSIResponse;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/ProfileServiceResponse;->si:Lcom/bestbuy/android/api/lib/models/registry/ProfileSIResponse;

    .line 30
    return-void
.end method
