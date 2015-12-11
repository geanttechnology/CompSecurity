.class public final enum Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
.super Ljava/lang/Enum;
.source "SortPolicy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SortType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum ALPHA:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum EXPIRING:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum NEW:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum RECENT:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field public static final enum YEAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 27
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "YEAR"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->YEAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "ALPHA"

    invoke-direct {v0, v1, v5}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "NEW"

    invoke-direct {v0, v1, v6}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NEW:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "RECENT"

    invoke-direct {v0, v1, v7}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->RECENT:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "EXPIRING"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->EXPIRING:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const-string v1, "POPULAR"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const/4 v0, 0x7

    new-array v0, v0, [Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->YEAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NEW:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->RECENT:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->EXPIRING:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

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
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 27
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->$VALUES:[Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    return-object v0
.end method
