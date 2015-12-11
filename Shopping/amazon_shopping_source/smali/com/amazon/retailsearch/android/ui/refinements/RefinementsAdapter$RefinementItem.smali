.class public Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;
.super Ljava/lang/Object;
.source "RefinementsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "RefinementItem"
.end annotation


# instance fields
.field private detail:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

.field private type:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->detail:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setDetail(Ljava/lang/String;)V
    .locals 0
    .param p1, "detail"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->detail:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->id:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->label:Ljava/lang/String;

    .line 99
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->type:Ljava/lang/String;

    .line 113
    return-void
.end method
