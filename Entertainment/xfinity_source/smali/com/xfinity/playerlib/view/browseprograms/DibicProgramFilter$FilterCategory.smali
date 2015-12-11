.class public final enum Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
.super Ljava/lang/Enum;
.source "DibicProgramFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FilterCategory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field public static final enum ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field public static final enum GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field public static final enum NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field public static final enum PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;


# instance fields
.field private final contentDescriptionResStringId:I

.field private final labelResStringId:I

.field private navListIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x3

    const/4 v11, 0x2

    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 259
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    const-string v1, "NETWORK"

    sget v3, Lcom/xfinity/playerlib/R$string;->filter_networks:I

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_filter_networks:I

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;-><init>(Ljava/lang/String;IIII)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 260
    new-instance v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    const-string v6, "GENRE"

    sget v8, Lcom/xfinity/playerlib/R$string;->filter_genres:I

    sget v10, Lcom/xfinity/playerlib/R$string;->content_description_filter_genres:I

    move v7, v4

    move v9, v2

    invoke-direct/range {v5 .. v10}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;-><init>(Ljava/lang/String;IIII)V

    sput-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 261
    new-instance v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    const-string v6, "PROGRAM_TYPE"

    sget v8, Lcom/xfinity/playerlib/R$string;->filter_type:I

    sget v10, Lcom/xfinity/playerlib/R$string;->content_description_filter_type:I

    move v7, v11

    move v9, v12

    invoke-direct/range {v5 .. v10}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;-><init>(Ljava/lang/String;IIII)V

    sput-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 262
    new-instance v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    const-string v6, "ALPHA"

    sget v8, Lcom/xfinity/playerlib/R$string;->filter_titles_atoz:I

    sget v10, Lcom/xfinity/playerlib/R$string;->content_description_filter_titles_atoz:I

    move v7, v12

    move v9, v11

    invoke-direct/range {v5 .. v10}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;-><init>(Ljava/lang/String;IIII)V

    sput-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .line 257
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    aput-object v1, v0, v11

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    aput-object v1, v0, v12

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IIII)V
    .locals 0
    .param p3, "labelResStringId"    # I
    .param p4, "index"    # I
    .param p5, "contentDescriptionResStringId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(III)V"
        }
    .end annotation

    .prologue
    .line 268
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 269
    iput p3, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->labelResStringId:I

    .line 270
    iput p4, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->navListIndex:I

    .line 271
    iput p5, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->contentDescriptionResStringId:I

    .line 272
    return-void
.end method

.method public static int2FilterCategory(I)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 293
    invoke-static {}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->values()[Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-result-object v2

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 294
    .local v0, "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 299
    .end local v0    # "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    :goto_1
    return-object v0

    .line 293
    .restart local v0    # "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 299
    .end local v0    # "category":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    :cond_1
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 257
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .locals 1

    .prologue
    .line 257
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    return-object v0
.end method


# virtual methods
.method public getContentDescription(Landroid/content/Context;)Ljava/lang/CharSequence;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 288
    iget v1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->contentDescriptionResStringId:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 289
    .local v0, "contentDescriptionType":Ljava/lang/String;
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_filter:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getLabel(Landroid/content/Context;)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 279
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->labelResStringId:I

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNavListIndex()I
    .locals 1

    .prologue
    .line 275
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->navListIndex:I

    return v0
.end method
