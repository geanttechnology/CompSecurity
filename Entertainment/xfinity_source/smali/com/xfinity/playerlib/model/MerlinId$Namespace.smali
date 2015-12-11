.class public final enum Lcom/xfinity/playerlib/model/MerlinId$Namespace;
.super Ljava/lang/Enum;
.source "MerlinId.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/MerlinId;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Namespace"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/model/MerlinId$Namespace;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/model/MerlinId$Namespace;

.field public static final enum Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

.field public static final enum TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

.field public static final enum TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const-string v1, "Movie"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    new-instance v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const-string v1, "TvSeries"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    new-instance v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const-string v1, "TvEpisode"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 13
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->$VALUES:[Lcom/xfinity/playerlib/model/MerlinId$Namespace;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->$VALUES:[Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/model/MerlinId$Namespace;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method


# virtual methods
.method public getBundleKey()Ljava/lang/String;
    .locals 2

    .prologue
    .line 17
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "EXTRA_MERLIN_ID_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
