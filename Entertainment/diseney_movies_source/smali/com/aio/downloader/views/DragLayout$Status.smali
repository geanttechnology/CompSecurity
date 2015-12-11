.class public final enum Lcom/aio/downloader/views/DragLayout$Status;
.super Ljava/lang/Enum;
.source "DragLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/DragLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Status"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/aio/downloader/views/DragLayout$Status;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum Close:Lcom/aio/downloader/views/DragLayout$Status;

.field public static final enum Drag:Lcom/aio/downloader/views/DragLayout$Status;

.field private static final synthetic ENUM$VALUES:[Lcom/aio/downloader/views/DragLayout$Status;

.field public static final enum Open:Lcom/aio/downloader/views/DragLayout$Status;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 201
    new-instance v0, Lcom/aio/downloader/views/DragLayout$Status;

    const-string v1, "Drag"

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/DragLayout$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/views/DragLayout$Status;->Drag:Lcom/aio/downloader/views/DragLayout$Status;

    new-instance v0, Lcom/aio/downloader/views/DragLayout$Status;

    const-string v1, "Open"

    invoke-direct {v0, v1, v3}, Lcom/aio/downloader/views/DragLayout$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/views/DragLayout$Status;->Open:Lcom/aio/downloader/views/DragLayout$Status;

    new-instance v0, Lcom/aio/downloader/views/DragLayout$Status;

    const-string v1, "Close"

    invoke-direct {v0, v1, v4}, Lcom/aio/downloader/views/DragLayout$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    .line 200
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/aio/downloader/views/DragLayout$Status;

    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Drag:Lcom/aio/downloader/views/DragLayout$Status;

    aput-object v1, v0, v2

    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Open:Lcom/aio/downloader/views/DragLayout$Status;

    aput-object v1, v0, v3

    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    aput-object v1, v0, v4

    sput-object v0, Lcom/aio/downloader/views/DragLayout$Status;->ENUM$VALUES:[Lcom/aio/downloader/views/DragLayout$Status;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 200
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/aio/downloader/views/DragLayout$Status;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/aio/downloader/views/DragLayout$Status;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/DragLayout$Status;

    return-object v0
.end method

.method public static values()[Lcom/aio/downloader/views/DragLayout$Status;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/aio/downloader/views/DragLayout$Status;->ENUM$VALUES:[Lcom/aio/downloader/views/DragLayout$Status;

    array-length v1, v0

    new-array v2, v1, [Lcom/aio/downloader/views/DragLayout$Status;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
