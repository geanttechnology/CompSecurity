.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
.super Ljava/lang/Object;
.source "TradeInModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel$Builder;
    }
.end annotation


# instance fields
.field private tradeInMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;->setTradeInMessage(Ljava/lang/String;)V

    return-void
.end method

.method private setTradeInMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "tradeInMessage"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;->tradeInMessage:Ljava/lang/String;

    .line 36
    return-void
.end method


# virtual methods
.method public getTradeInMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/TradeInModel;->tradeInMessage:Ljava/lang/String;

    return-object v0
.end method
