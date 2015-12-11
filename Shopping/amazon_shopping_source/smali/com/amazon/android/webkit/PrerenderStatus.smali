.class public final enum Lcom/amazon/android/webkit/PrerenderStatus;
.super Ljava/lang/Enum;
.source "PrerenderStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/android/webkit/PrerenderStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_APP_TERMINATING:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_AUTH_NEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_CACHE_OR_HISTORY_CLEARED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_CANCELLED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_CONTROL_GROUP:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_CREATE_NEW_WINDOW:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_DEVTOOLS_ATTACHED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_DOWNLOAD:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_EVICTED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_FRAGMENT_MISMATCH:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_HTML5_MEDIA:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_HTTPS:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_INVALID_HTTP_METHOD:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_JAVASCRIPT_ALERT:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_JS_OUT_OF_MEMORY:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_MANAGER_SHUTDOWN:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_MEMORY_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_OPEN_URL:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_PAGE_ID_CONFLICT:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_PROFILE_DESTROYED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_RATE_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_RECENTLY_VISITED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_RENDERER_CRASHED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_SAFE_BROWSING:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_SSL_ERROR:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_TIMED_OUT:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_TOO_MANY_PROCESSES:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_UNKNOWN:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_UNSUPPORTED_SCHEME:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_USED:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_WINDOW_OPENER:Lcom/amazon/android/webkit/PrerenderStatus;

.field public static final enum FINAL_STATUS_WINDOW_PRINT:Lcom/amazon/android/webkit/PrerenderStatus;


# instance fields
.field private final status:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x5

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 11
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_UNKNOWN"

    const/4 v2, -0x1

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_UNKNOWN:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 12
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_USED"

    invoke-direct {v0, v1, v5, v4}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_USED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 13
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_TIMED_OUT"

    invoke-direct {v0, v1, v6, v5}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_TIMED_OUT:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 14
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_EVICTED"

    invoke-direct {v0, v1, v7, v6}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_EVICTED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 15
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_MANAGER_SHUTDOWN"

    const/4 v2, 0x4

    invoke-direct {v0, v1, v2, v7}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_MANAGER_SHUTDOWN:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 17
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_CREATE_NEW_WINDOW"

    invoke-direct {v0, v1, v8, v8}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CREATE_NEW_WINDOW:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 18
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_PROFILE_DESTROYED"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_PROFILE_DESTROYED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 19
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_APP_TERMINATING"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_APP_TERMINATING:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 20
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_JAVASCRIPT_ALERT"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_JAVASCRIPT_ALERT:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 21
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_AUTH_NEEDED"

    const/16 v2, 0x9

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_AUTH_NEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 22
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_HTTPS"

    const/16 v2, 0xa

    const/16 v3, 0xa

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_HTTPS:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 23
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_DOWNLOAD"

    const/16 v2, 0xb

    const/16 v3, 0xb

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_DOWNLOAD:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 24
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_MEMORY_LIMIT_EXCEEDED"

    const/16 v2, 0xc

    const/16 v3, 0xc

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_MEMORY_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 25
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_JS_OUT_OF_MEMORY"

    const/16 v2, 0xd

    const/16 v3, 0xd

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_JS_OUT_OF_MEMORY:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 27
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_TOO_MANY_PROCESSES"

    const/16 v2, 0xe

    const/16 v3, 0xf

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_TOO_MANY_PROCESSES:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 28
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_RATE_LIMIT_EXCEEDED"

    const/16 v2, 0xf

    const/16 v3, 0x10

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RATE_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 30
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_CONTROL_GROUP"

    const/16 v2, 0x10

    const/16 v3, 0x12

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CONTROL_GROUP:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 31
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_HTML5_MEDIA"

    const/16 v2, 0x11

    const/16 v3, 0x13

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_HTML5_MEDIA:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 32
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED"

    const/16 v2, 0x12

    const/16 v3, 0x14

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 33
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_RENDERER_CRASHED"

    const/16 v2, 0x13

    const/16 v3, 0x15

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RENDERER_CRASHED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 34
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_UNSUPPORTED_SCHEME"

    const/16 v2, 0x14

    const/16 v3, 0x16

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_UNSUPPORTED_SCHEME:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 35
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_INVALID_HTTP_METHOD"

    const/16 v2, 0x15

    const/16 v3, 0x17

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_INVALID_HTTP_METHOD:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 36
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_WINDOW_PRINT"

    const/16 v2, 0x16

    const/16 v3, 0x18

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_WINDOW_PRINT:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 37
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_RECENTLY_VISITED"

    const/16 v2, 0x17

    const/16 v3, 0x19

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RECENTLY_VISITED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 38
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_WINDOW_OPENER"

    const/16 v2, 0x18

    const/16 v3, 0x1a

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_WINDOW_OPENER:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 39
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_PAGE_ID_CONFLICT"

    const/16 v2, 0x19

    const/16 v3, 0x1b

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_PAGE_ID_CONFLICT:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 40
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_SAFE_BROWSING"

    const/16 v2, 0x1a

    const/16 v3, 0x1c

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SAFE_BROWSING:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 41
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_FRAGMENT_MISMATCH"

    const/16 v2, 0x1b

    const/16 v3, 0x1d

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_FRAGMENT_MISMATCH:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 42
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED"

    const/16 v2, 0x1c

    const/16 v3, 0x1e

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 43
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_CACHE_OR_HISTORY_CLEARED"

    const/16 v2, 0x1d

    const/16 v3, 0x1f

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CACHE_OR_HISTORY_CLEARED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 44
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_CANCELLED"

    const/16 v2, 0x1e

    const/16 v3, 0x20

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CANCELLED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 45
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_SSL_ERROR"

    const/16 v2, 0x1f

    const/16 v3, 0x21

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SSL_ERROR:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 46
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING"

    const/16 v2, 0x20

    const/16 v3, 0x22

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 47
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_DEVTOOLS_ATTACHED"

    const/16 v2, 0x21

    const/16 v3, 0x23

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_DEVTOOLS_ATTACHED:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 48
    new-instance v0, Lcom/amazon/android/webkit/PrerenderStatus;

    const-string/jumbo v1, "FINAL_STATUS_OPEN_URL"

    const/16 v2, 0x22

    const/16 v3, 0x28

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/webkit/PrerenderStatus;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_OPEN_URL:Lcom/amazon/android/webkit/PrerenderStatus;

    .line 10
    const/16 v0, 0x23

    new-array v0, v0, [Lcom/amazon/android/webkit/PrerenderStatus;

    sget-object v1, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_UNKNOWN:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_USED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_TIMED_OUT:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_EVICTED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v1, v0, v7

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_MANAGER_SHUTDOWN:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CREATE_NEW_WINDOW:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v1, v0, v8

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_PROFILE_DESTROYED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_APP_TERMINATING:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_JAVASCRIPT_ALERT:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_AUTH_NEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_HTTPS:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_DOWNLOAD:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_MEMORY_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_JS_OUT_OF_MEMORY:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_TOO_MANY_PROCESSES:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RATE_LIMIT_EXCEEDED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CONTROL_GROUP:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_HTML5_MEDIA:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RENDERER_CRASHED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_UNSUPPORTED_SCHEME:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_INVALID_HTTP_METHOD:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_WINDOW_PRINT:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_RECENTLY_VISITED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_WINDOW_OPENER:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_PAGE_ID_CONFLICT:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SAFE_BROWSING:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_FRAGMENT_MISMATCH:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CACHE_OR_HISTORY_CLEARED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CANCELLED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_SSL_ERROR:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_DEVTOOLS_ATTACHED:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/android/webkit/PrerenderStatus;->FINAL_STATUS_OPEN_URL:Lcom/amazon/android/webkit/PrerenderStatus;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->$VALUES:[Lcom/amazon/android/webkit/PrerenderStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "status"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 57
    iput p3, p0, Lcom/amazon/android/webkit/PrerenderStatus;->status:I

    .line 58
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/android/webkit/PrerenderStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/amazon/android/webkit/PrerenderStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/webkit/PrerenderStatus;

    return-object v0
.end method

.method public static values()[Lcom/amazon/android/webkit/PrerenderStatus;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/amazon/android/webkit/PrerenderStatus;->$VALUES:[Lcom/amazon/android/webkit/PrerenderStatus;

    invoke-virtual {v0}, [Lcom/amazon/android/webkit/PrerenderStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/android/webkit/PrerenderStatus;

    return-object v0
.end method
