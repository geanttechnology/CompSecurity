.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
.super Ljava/lang/Object;
.source "FastTrackModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel$Builder;
    }
.end annotation


# instance fields
.field private fastTrackStyledText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;->setFastTrackStyledText(Ljava/util/List;)V

    return-void
.end method

.method private setFastTrackStyledText(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "fastTrackStyledText":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;->fastTrackStyledText:Ljava/util/List;

    .line 38
    return-void
.end method


# virtual methods
.method public getFastTrackSyledText()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/FastTrackModel;->fastTrackStyledText:Ljava/util/List;

    return-object v0
.end method
