.class final enum Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;
.super Ljava/lang/Enum;
.source "RetailSearchSuggestionRow.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "RowType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

.field public static final enum ICON:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

.field public static final enum SUGGESTION:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 24
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    const-string/jumbo v1, "SUGGESTION"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->SUGGESTION:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    .line 25
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    const-string/jumbo v1, "ICON"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->ICON:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    .line 22
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->SUGGESTION:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->ICON:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

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
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 22
    const-class v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    return-object v0
.end method
