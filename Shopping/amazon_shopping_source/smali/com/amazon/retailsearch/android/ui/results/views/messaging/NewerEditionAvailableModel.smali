.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
.super Ljava/lang/Object;
.source "NewerEditionAvailableModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel$Builder;
    }
.end annotation


# instance fields
.field private asin:Ljava/lang/String;

.field private newerVersionText:Ljava/lang/String;

.field private newerVersionUrl:Ljava/lang/String;

.field private productGroup:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setAsin(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setNewerVersionText(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setNewerVersionUrl(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->setProductGroup(Ljava/lang/String;)V

    return-void
.end method

.method private setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->asin:Ljava/lang/String;

    .line 33
    return-void
.end method

.method private setNewerVersionText(Ljava/lang/String;)V
    .locals 0
    .param p1, "newerVersionText"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->newerVersionText:Ljava/lang/String;

    .line 49
    return-void
.end method

.method private setNewerVersionUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "newerVersionUrl"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->newerVersionUrl:Ljava/lang/String;

    .line 65
    return-void
.end method

.method private setProductGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "productGroup"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->productGroup:Ljava/lang/String;

    .line 75
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getNewerVersionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->newerVersionText:Ljava/lang/String;

    return-object v0
.end method

.method public getNewerVersionUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->newerVersionUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getProductGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->productGroup:Ljava/lang/String;

    return-object v0
.end method
