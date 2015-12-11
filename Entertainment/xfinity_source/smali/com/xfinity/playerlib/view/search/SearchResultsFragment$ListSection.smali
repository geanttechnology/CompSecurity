.class public final enum Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;
.super Ljava/lang/Enum;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ListSection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

.field public static final enum FULL:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

.field public static final enum NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 636
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    const-string v1, "NEW"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    const-string v1, "FULL"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->FULL:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    .line 635
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    sget-object v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->FULL:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    aput-object v1, v0, v3

    sput-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->$VALUES:[Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 635
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 635
    const-class v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;
    .locals 1

    .prologue
    .line 635
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->$VALUES:[Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    return-object v0
.end method
