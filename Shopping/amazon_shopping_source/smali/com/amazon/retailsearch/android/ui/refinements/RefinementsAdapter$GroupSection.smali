.class final enum Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
.super Ljava/lang/Enum;
.source "RefinementsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "GroupSection"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

.field public static final enum Unknown:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 54
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "PrioritizedFilter"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 55
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "Department"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 56
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "Sort"

    invoke-direct {v0, v1, v5}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 57
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "Filter"

    invoke-direct {v0, v1, v6}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 58
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "SeeMore"

    invoke-direct {v0, v1, v7}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 59
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    const-string/jumbo v1, "Unknown"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Unknown:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 52
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Unknown:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->$VALUES:[Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

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
    .line 52
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 52
    const-class v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->$VALUES:[Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    return-object v0
.end method
