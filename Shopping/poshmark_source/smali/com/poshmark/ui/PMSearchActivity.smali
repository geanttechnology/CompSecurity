.class public Lcom/poshmark/ui/PMSearchActivity;
.super Lcom/poshmark/ui/PMContainerActivity;
.source "PMSearchActivity.java"


# instance fields
.field searchManager:Lcom/poshmark/utils/FilterResultsManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/poshmark/ui/PMContainerActivity;-><init>()V

    .line 8
    new-instance v0, Lcom/poshmark/utils/FilterResultsManager;

    invoke-direct {v0}, Lcom/poshmark/utils/FilterResultsManager;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/PMSearchActivity;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    return-void
.end method


# virtual methods
.method public getSearchManager()Lcom/poshmark/utils/FilterResultsManager;
    .locals 1

    .prologue
    .line 11
    iget-object v0, p0, Lcom/poshmark/ui/PMSearchActivity;->searchManager:Lcom/poshmark/utils/FilterResultsManager;

    return-object v0
.end method
