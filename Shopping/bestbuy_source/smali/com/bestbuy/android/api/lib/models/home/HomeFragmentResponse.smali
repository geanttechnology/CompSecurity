.class public Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x7a703670118761caL


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->si:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->si:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    .line 30
    return-void
.end method
