.class public Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
.super Ljava/lang/Object;
.source "BestSellerModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel$Builder;
    }
.end annotation


# instance fields
.field private badgeId:Ljava/lang/String;

.field private departmentLabel:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->setBadgeId(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->setDepartmentLabel(Ljava/lang/String;)V

    return-void
.end method

.method private setBadgeId(Ljava/lang/String;)V
    .locals 0
    .param p1, "badgeId"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->badgeId:Ljava/lang/String;

    .line 39
    return-void
.end method

.method private setDepartmentLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "departmentLabel"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->departmentLabel:Ljava/lang/String;

    .line 56
    return-void
.end method


# virtual methods
.method public getBadgeId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->badgeId:Ljava/lang/String;

    return-object v0
.end method

.method public getDepartmentLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/BestSellerModel;->departmentLabel:Ljava/lang/String;

    return-object v0
.end method
