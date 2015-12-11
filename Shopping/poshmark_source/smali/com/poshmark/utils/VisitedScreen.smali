.class public Lcom/poshmark/utils/VisitedScreen;
.super Ljava/lang/Object;
.source "VisitedScreen.java"


# instance fields
.field fragmentID:Ljava/util/UUID;

.field screenName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/UUID;Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/util/UUID;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/poshmark/utils/VisitedScreen;->fragmentID:Ljava/util/UUID;

    .line 14
    iput-object p2, p0, Lcom/poshmark/utils/VisitedScreen;->screenName:Ljava/lang/String;

    .line 15
    return-void
.end method
