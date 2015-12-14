.class Lcom/livemixtapes/Mixtape$1;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/Mixtape;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$1;->this$0:Lcom/livemixtapes/Mixtape;

    .line 986
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClickDj(Ljava/lang/String;)V
    .locals 1
    .param p1, "dj"    # Ljava/lang/String;

    .prologue
    .line 989
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$1;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v0, p1}, Lcom/livemixtapes/Mixtape;->loadDjList(Ljava/lang/String;)V

    .line 990
    return-void
.end method
