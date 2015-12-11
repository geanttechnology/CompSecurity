.class public final enum Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;
.super Ljava/lang/Enum;
.source "FeedItemPopulator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/FeedItemPopulator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "COVERSHOT_SIZE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

.field public static final enum LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

.field public static final enum MEDIUM:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

.field public static final enum SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 35
    new-instance v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    const-string v1, "LARGE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    new-instance v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    const-string v1, "MEDIUM"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->MEDIUM:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    new-instance v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    const-string v1, "SMALL"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    sget-object v1, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->MEDIUM:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->$VALUES:[Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 35
    const-class v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->$VALUES:[Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    return-object v0
.end method
