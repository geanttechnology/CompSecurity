.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;
.super Ljava/lang/Object;
.source "EsrbRatingModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel$Builder;
    }
.end annotation


# instance fields
.field private esrbRatingMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;->setEsrbRatingMessage(Ljava/lang/String;)V

    return-void
.end method

.method private setEsrbRatingMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "esrbRatingMessage"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;->esrbRatingMessage:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public getEsrbRatingMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EsrbRatingModel;->esrbRatingMessage:Ljava/lang/String;

    return-object v0
.end method
