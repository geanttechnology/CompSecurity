.class Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;
.super Ljava/lang/Object;
.source "SavedSearchController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/controllers/SavedSearchController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SuggestionsData"
.end annotation


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/SuggestedSearchItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/controllers/SavedSearchController;

.field versionCode:I


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/SavedSearchController;)V
    .locals 1

    .prologue
    .line 134
    iput-object p1, p0, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->this$0:Lcom/poshmark/controllers/SavedSearchController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 135
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->versionCode:I

    .line 136
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/controllers/SavedSearchController$SuggestionsData;->data:Ljava/util/List;

    return-void
.end method
