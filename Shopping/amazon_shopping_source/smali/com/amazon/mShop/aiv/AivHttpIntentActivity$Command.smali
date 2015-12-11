.class abstract enum Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
.super Ljava/lang/Enum;
.source "AivHttpIntentActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AivHttpIntentActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4408
    name = "Command"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

.field private static final DEFAULT_LENGTH:I = 0x5

.field public static final enum DETAILPAGE:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

.field public static final enum PLAY:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

.field public static final enum PLAYTRAILER:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

.field public static final enum RESUME:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;


# instance fields
.field private final mLength:I

.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    new-instance v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$1;

    const-string/jumbo v1, "DETAILPAGE"

    const-string/jumbo v2, "detailpage"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$1;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->DETAILPAGE:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    .line 36
    new-instance v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$2;

    const-string/jumbo v1, "PLAY"

    const-string/jumbo v2, "play"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$2;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->PLAY:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    .line 41
    new-instance v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$3;

    const-string/jumbo v1, "RESUME"

    const-string/jumbo v2, "resume"

    const/4 v3, 0x6

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$3;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->RESUME:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    .line 48
    new-instance v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$4;

    const-string/jumbo v1, "PLAYTRAILER"

    const-string/jumbo v2, "playtrailer"

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$4;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->PLAYTRAILER:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    .line 28
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    sget-object v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->DETAILPAGE:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->PLAY:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->RESUME:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->PLAYTRAILER:Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    aput-object v1, v0, v7

    sput-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->$VALUES:[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 60
    const/4 v0, 0x5

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    .line 61
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;I)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "length"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 63
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 64
    iput-object p3, p0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->mName:Ljava/lang/String;

    .line 65
    iput p4, p0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->mLength:I

    .line 66
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILjava/lang/String;ILcom/amazon/mShop/aiv/AivHttpIntentActivity$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # I
    .param p5, "x4"    # Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    return-void
.end method

.method public static performCommandForSegments(Landroid/app/Activity;Ljava/util/List;)V
    .locals 13
    .param p0, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "segments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v9, 0x5

    const/4 v8, 0x3

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 72
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v4

    .line 73
    .local v4, "length":I
    if-gt v4, v9, :cond_0

    .line 74
    # getter for: Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->access$100()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Not enough segments. %d required, %d provided. %s"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    aput-object p1, v8, v12

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 92
    :goto_0
    return-void

    .line 78
    :cond_0
    invoke-interface {p1, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 79
    .local v5, "name":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->values()[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_3

    aget-object v1, v0, v2

    .line 80
    .local v1, "command":Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    iget-object v6, v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->mName:Ljava/lang/String;

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 81
    iget v6, v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->mLength:I

    if-lt v4, v6, :cond_1

    .line 82
    invoke-virtual {v1, p0, p1}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->performCommand(Landroid/app/Activity;Ljava/util/List;)V

    goto :goto_0

    .line 84
    :cond_1
    # getter for: Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->access$100()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Command %s requires %d path elements. Only %d supplied."

    new-array v8, v8, [Ljava/lang/Object;

    aput-object v1, v8, v10

    iget v9, v1, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->mLength:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 79
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 90
    .end local v1    # "command":Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    :cond_3
    # getter for: Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity;->access$100()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Could not find command: %s, path: %s, available options: %s"

    new-array v8, v8, [Ljava/lang/Object;

    aput-object v5, v8, v10

    aput-object p1, v8, v11

    invoke-static {}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->values()[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    move-result-object v9

    invoke-static {v9}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 28
    const-class v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->$VALUES:[Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    invoke-virtual {v0}, [Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;

    return-object v0
.end method


# virtual methods
.method public abstract performCommand(Landroid/app/Activity;Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method
