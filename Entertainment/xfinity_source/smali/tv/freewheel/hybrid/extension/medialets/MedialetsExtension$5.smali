.class synthetic Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 122
    invoke-static {}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->values()[Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;->$SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I

    :try_start_0
    sget-object v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;->$SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I

    sget-object v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->START:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    :try_start_1
    sget-object v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;->$SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I

    sget-object v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->RESUME:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    :try_start_2
    sget-object v0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$5;->$SwitchMap$tv$freewheel$hybrid$extension$medialets$MedialetsExtension$MedialetsAdmanagerState:[I

    sget-object v1, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->STOP:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$MedialetsAdmanagerState;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_2
    return-void

    :catch_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_0
.end method
