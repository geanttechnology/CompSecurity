.class public final enum Lcom/uplynk/media/CaptionEvent$CaptionMode;
.super Ljava/lang/Enum;
.source "CaptionEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CaptionMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/uplynk/media/CaptionEvent$CaptionMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public static final enum PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public static final enum POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public static final enum ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public static final enum TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public static final enum UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 10
    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionEvent$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const-string v1, "POP_ON"

    invoke-direct {v0, v1, v3}, Lcom/uplynk/media/CaptionEvent$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const-string v1, "ROLL_UP"

    invoke-direct {v0, v1, v4}, Lcom/uplynk/media/CaptionEvent$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const-string v1, "PAINT_ON"

    invoke-direct {v0, v1, v5}, Lcom/uplynk/media/CaptionEvent$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    new-instance v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v6}, Lcom/uplynk/media/CaptionEvent$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->PAINT_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    aput-object v1, v0, v6

    sput-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ENUM$VALUES:[Lcom/uplynk/media/CaptionEvent$CaptionMode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/uplynk/media/CaptionEvent$CaptionMode;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;

    return-object v0
.end method

.method public static values()[Lcom/uplynk/media/CaptionEvent$CaptionMode;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ENUM$VALUES:[Lcom/uplynk/media/CaptionEvent$CaptionMode;

    array-length v1, v0

    new-array v2, v1, [Lcom/uplynk/media/CaptionEvent$CaptionMode;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
