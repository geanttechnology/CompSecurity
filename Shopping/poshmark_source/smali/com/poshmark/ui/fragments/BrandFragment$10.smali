.class synthetic Lcom/poshmark/ui/fragments/BrandFragment$10;
.super Ljava/lang/Object;
.source "BrandFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/BrandFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 604
    invoke-static {}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->values()[Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment$10;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    :try_start_0
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$10;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    sget-object v1, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Left:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    :try_start_1
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$10;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    sget-object v1, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Center:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    :try_start_2
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$10;->$SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType:[I

    sget-object v1, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->Right:Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_2
    return-void

    :catch_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_0
.end method
