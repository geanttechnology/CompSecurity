.class final Lcom/wishabi/flipp/app/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Landroid/content/SharedPreferences;

.field final synthetic b:Lcom/wishabi/flipp/app/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/a;Landroid/content/SharedPreferences;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/wishabi/flipp/app/b;->b:Lcom/wishabi/flipp/app/a;

    iput-object p2, p0, Lcom/wishabi/flipp/app/b;->a:Landroid/content/SharedPreferences;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "CommitPrefEdits"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 31
    iget-object v0, p0, Lcom/wishabi/flipp/app/b;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 33
    packed-switch p2, :pswitch_data_0

    .line 41
    :goto_0
    const-string v1, "has_responded_to_push_prompt"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 42
    return-void

    .line 35
    :pswitch_0
    const-string v1, "allow_push"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 38
    :pswitch_1
    const-string v1, "allow_push"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 33
    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
