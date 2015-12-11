.class public final enum Lcom/adobe/mediacore/MediaPlayerEvent$Type;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayerEvent$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_CLICK:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AD_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AUDIO_TRACK_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum AUDIO_TRACK_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum BACKGROUND_MANIFEST_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum BUFFERING_FULL:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum BUFFERING_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum CONTENT_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum DRM_METADATA:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ITEM_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ITEM_READY:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ITEM_REPLACED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum LOAD_INFO:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum OPERATION_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum OPPORTUNITY_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PLAYBACK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PLAYBACK_PAUSED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PLAYBACK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PLAY_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PLAY_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PREPARED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum PROFILE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum RATE_PLAYING:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum RATE_SELECTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum RESOURCE_LOADED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum SEEK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum SEEK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum TIMED_METADATA_ADDED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum TIMED_METADATA_ADDED_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum TIMED_METADATA_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum VIDEO_ERROR:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum VIDEO_STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

.field public static final enum VIEW_CLICKED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "RESOURCE_LOADED"

    invoke-direct {v0, v1, v3}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RESOURCE_LOADED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ITEM_CREATED"

    invoke-direct {v0, v1, v4}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ITEM_UPDATED"

    invoke-direct {v0, v1, v5}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ITEM_REPLACED"

    invoke-direct {v0, v1, v6}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_REPLACED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ITEM_READY"

    invoke-direct {v0, v1, v7}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_READY:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ADBREAK_PLACEMENT_COMPLETED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ADBREAK_PLACEMENT_FAILED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "CONTENT_MARKER"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "CONTENT_PLACEMENT_COMPLETE"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_MANIFEST_LOAD_COMPLETE"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_MANIFEST_LOAD_FAILED"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_BREAK_MANIFEST_LOAD_COMPLETE"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "CONTENT_CHANGED"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PROFILE_CHANGED"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PROFILE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "SEEK_STARTED"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "SEEK_COMPLETED"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "SEEK_ADJUST_COMPLETED"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "BUFFERING_STARTED"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "BUFFERING_FULL"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_FULL:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "BUFFERING_COMPLETED"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AUDIO_TRACK_FAILED"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AUDIO_TRACK_CHANGED"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "LOAD_INFO"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->LOAD_INFO:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "DRM_METADATA"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->DRM_METADATA:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "BACKGROUND_MANIFEST_FAILED"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BACKGROUND_MANIFEST_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PLAYBACK_STARTED"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PLAYBACK_PAUSED"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_PAUSED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PLAYBACK_COMPLETED"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "VIEW_CLICKED"

    const/16 v2, 0x1c

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIEW_CLICKED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PREPARED"

    const/16 v2, 0x1d

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PREPARED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "UPDATED"

    const/16 v2, 0x1e

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "TIMELINE_UPDATED"

    const/16 v2, 0x1f

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PLAY_START"

    const/16 v2, 0x20

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "STATE_CHANGED"

    const/16 v2, 0x21

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "VIDEO_STATE_CHANGED"

    const/16 v2, 0x22

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "PLAY_COMPLETE"

    const/16 v2, 0x23

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "TIMED_METADATA_ADDED"

    const/16 v2, 0x24

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "TIMED_METADATA_ADDED_IN_BACKGROUND"

    const/16 v2, 0x25

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "SIZE_CHANGED"

    const/16 v2, 0x26

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_BREAK_START"

    const/16 v2, 0x27

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_BREAK_COMPLETE"

    const/16 v2, 0x28

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_BREAK_SKIPPED"

    const/16 v2, 0x29

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_START"

    const/16 v2, 0x2a

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_PROGRESS"

    const/16 v2, 0x2b

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_COMPLETE"

    const/16 v2, 0x2c

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "AD_CLICK"

    const/16 v2, 0x2d

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "VIDEO_ERROR"

    const/16 v2, 0x2e

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_ERROR:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "OPPORTUNITY_COMPLETED"

    const/16 v2, 0x2f

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "OPPORTUNITY_CREATED"

    const/16 v2, 0x30

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "OPPORTUNITY_FAILED"

    const/16 v2, 0x31

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "TIMED_METADATA_SKIPPED"

    const/16 v2, 0x32

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "ADBREAK_REMOVAL_COMPLETED"

    const/16 v2, 0x33

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "OPERATION_FAILED"

    const/16 v2, 0x34

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPERATION_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "RATE_SELECTED"

    const/16 v2, 0x35

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_SELECTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const-string v1, "RATE_PLAYING"

    const/16 v2, 0x36

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_PLAYING:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    const/16 v0, 0x37

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RESOURCE_LOADED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_REPLACED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ITEM_READY:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PROFILE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_FULL:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BUFFERING_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->LOAD_INFO:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->DRM_METADATA:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BACKGROUND_MANIFEST_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_STARTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_PAUSED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAYBACK_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIEW_CLICKED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PREPARED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_ERROR:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x30

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_CREATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x31

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x32

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_SKIPPED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x33

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x34

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPERATION_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x35

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_SELECTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    const/16 v1, 0x36

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_PLAYING:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerEvent$Type;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayerEvent$Type;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayerEvent$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    return-object v0
.end method
