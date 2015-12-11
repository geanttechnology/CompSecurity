.class final enum Lcom/aio/downloader/pager/JazzyViewPager$State;
.super Ljava/lang/Enum;
.source "JazzyViewPager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/pager/JazzyViewPager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/aio/downloader/pager/JazzyViewPager$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/aio/downloader/pager/JazzyViewPager$State;

.field public static final enum GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

.field public static final enum GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

.field public static final enum IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 164
    new-instance v0, Lcom/aio/downloader/pager/JazzyViewPager$State;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 165
    new-instance v0, Lcom/aio/downloader/pager/JazzyViewPager$State;

    const-string v1, "GOING_LEFT"

    invoke-direct {v0, v1, v3}, Lcom/aio/downloader/pager/JazzyViewPager$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 166
    new-instance v0, Lcom/aio/downloader/pager/JazzyViewPager$State;

    const-string v1, "GOING_RIGHT"

    invoke-direct {v0, v1, v4}, Lcom/aio/downloader/pager/JazzyViewPager$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 163
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    aput-object v1, v0, v4

    sput-object v0, Lcom/aio/downloader/pager/JazzyViewPager$State;->ENUM$VALUES:[Lcom/aio/downloader/pager/JazzyViewPager$State;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 163
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/aio/downloader/pager/JazzyViewPager$State;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/aio/downloader/pager/JazzyViewPager$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/pager/JazzyViewPager$State;

    return-object v0
.end method

.method public static values()[Lcom/aio/downloader/pager/JazzyViewPager$State;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/aio/downloader/pager/JazzyViewPager$State;->ENUM$VALUES:[Lcom/aio/downloader/pager/JazzyViewPager$State;

    array-length v1, v0

    new-array v2, v1, [Lcom/aio/downloader/pager/JazzyViewPager$State;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
