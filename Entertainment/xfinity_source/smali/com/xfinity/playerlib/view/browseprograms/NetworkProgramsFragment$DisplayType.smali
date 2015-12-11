.class public final enum Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
.super Ljava/lang/Enum;
.source "NetworkProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DisplayType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

.field public static final enum ALL_MOVIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

.field public static final enum ALL_TV_SERIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

.field public static final enum COLLECTION:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 181
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    const-string v1, "ALL_MOVIES"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_MOVIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    const-string v1, "ALL_TV_SERIES"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_TV_SERIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    const-string v1, "COLLECTION"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->COLLECTION:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_MOVIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_TV_SERIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->COLLECTION:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

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
    .line 181
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 181
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
    .locals 1

    .prologue
    .line 181
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    return-object v0
.end method
