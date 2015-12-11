.class public final enum Lcom/auditude/ads/event/SMILEvent$SMILEventType;
.super Ljava/lang/Enum;
.source "SMILEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/event/SMILEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SMILEventType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/auditude/ads/event/SMILEvent$SMILEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/auditude/ads/event/SMILEvent$SMILEventType;

.field public static final enum PAR_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

.field public static final enum PAR_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

.field public static final enum SEQUENCE_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

.field public static final enum SEQUENCE_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    const-string v1, "SEQUENCE_BEGIN"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    .line 13
    new-instance v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    const-string v1, "SEQUENCE_END"

    invoke-direct {v0, v1, v3}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    .line 14
    new-instance v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    const-string v1, "PAR_BEGIN"

    invoke-direct {v0, v1, v4}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    .line 15
    new-instance v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    const-string v1, "PAR_END"

    invoke-direct {v0, v1, v5}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    .line 10
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ENUM$VALUES:[Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/auditude/ads/event/SMILEvent$SMILEventType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    return-object v0
.end method

.method public static values()[Lcom/auditude/ads/event/SMILEvent$SMILEventType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ENUM$VALUES:[Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    array-length v1, v0

    new-array v2, v1, [Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
