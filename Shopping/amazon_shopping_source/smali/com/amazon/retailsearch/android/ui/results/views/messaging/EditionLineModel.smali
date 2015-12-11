.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
.super Ljava/lang/Object;
.source "EditionLineModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel$Builder;
    }
.end annotation


# instance fields
.field private editionText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    return-void
.end method


# virtual methods
.method public getEditionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->editionText:Ljava/lang/String;

    return-object v0
.end method

.method public setEditionText(Ljava/lang/String;)V
    .locals 0
    .param p1, "editionText"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->editionText:Ljava/lang/String;

    .line 36
    return-void
.end method
