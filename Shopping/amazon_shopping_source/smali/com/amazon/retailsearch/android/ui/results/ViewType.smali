.class public final enum Lcom/amazon/retailsearch/android/ui/results/ViewType;
.super Ljava/lang/Enum;
.source "ViewType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/ViewType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/ui/results/ViewType;

.field public static final enum GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

.field public static final enum GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

.field public static final enum ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

.field public static final enum SplitView:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# instance fields
.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 15
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    const-string/jumbo v1, "ListView"

    const-string/jumbo v2, "List"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 16
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    const-string/jumbo v1, "GridView"

    const-string/jumbo v2, "Grid"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 17
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    const-string/jumbo v1, "GalleryView"

    const-string/jumbo v2, "Gallery"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 18
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    const-string/jumbo v1, "SplitView"

    const-string/jumbo v2, "Split"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->SplitView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 13
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/results/ViewType;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/ViewType;->ListView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GridView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/ViewType;->GalleryView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/ViewType;->SplitView:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/ViewType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 33
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->name:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public static findByNameIgnoreCase(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 5
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->values()[Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/retailsearch/android/ui/results/ViewType;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v2, v0, v1

    .line 54
    .local v2, "item":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 60
    .end local v2    # "item":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :goto_1
    return-object v2

    .line 52
    .restart local v2    # "item":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 60
    .end local v2    # "item":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/ui/results/ViewType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/ViewType;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/ui/results/ViewType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/ui/results/ViewType;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ViewType;->name:Ljava/lang/String;

    return-object v0
.end method
