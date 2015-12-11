.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
.super Ljava/lang/Object;
.source "VariationsModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel$Builder;
    }
.end annotation


# instance fields
.field private variationsMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->setVariationsMessage(Ljava/lang/String;)V

    return-void
.end method

.method private setVariationsMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "variationsMessage"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->variationsMessage:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public getVariationsMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->variationsMessage:Ljava/lang/String;

    return-object v0
.end method
